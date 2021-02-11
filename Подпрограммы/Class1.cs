using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;
using System.IO;

namespace Подпрограммы
{
    public class Class1
    {

        public static double vvod(TextBox t)
        {
            return Convert.ToDouble(t.Text);
        }

        public static void enter_array1(int n, params int[] masArr1) // создание рандомного массива
        {
            Random a = new Random();
            for (int i = 0; i < n; i++)
            {
                masArr1[i] = (int)(a.Next() % 900) / 20 - 20;
            }
        }
        public static void output_mas(int len, DataGridView grid, params int[] masArr1)// вывод массива
        {
            grid.ColumnCount = len;
            grid.RowCount = 2;

            for (int i = 0; i < len; i++)
            {
                grid.Rows[0].Cells[i].Value = "[" + i + "]";
                grid.Rows[1].Cells[i].Value = masArr1[i];


            }
            int Width = 0;
            for (int s = 0; s < grid.ColumnCount; s++)
            {
                Width += grid.Columns[s].Width;
            }
            if (Width > 1200)
            {
                grid.Width = 1200;
            }
            else
                grid.Width = Width;
        }


        public static void ChangeMass(int n, ref int k, int[] mass)
        {

            for (int i = 0; i < n; i++)
            {

                if (mass[i] % 10 != 0)
                {
                    k = k + 1;

                }
            }
        }
        public static void Newmass(int n1, int n2, int[] mas, params int[] resmas)
        {
            int j = 0;
            for (int i = 0; i < n1; i++)
            {
                
                    if (mas[i] % 10 != 0)
                    {
                        resmas[j] = mas[i];
                        j++;
                    }
                
            }
        }

        
       public static void Add_toNotebook(ref int[] mass,  int len)
       {
           StreamWriter rez = File.CreateText("Результат.txt");
           rez.WriteLine("Результат");
           for (int i = 0; i < len; i++)
              
        
           {
               rez.WriteLine( " " +  mass[i] +  " " );
           }

           MessageBox.Show("В Блокнот добавлены массивы", "Информация", MessageBoxButtons.OK, MessageBoxIcon.None);
               rez.Close();
               System.Diagnostics.Process.Start("Результат.txt");

       }

       public static void add()
       {
           var k = new ADOX.Catalog();
           try
           {
               k.Create("Provider= Microsoft.Jet.OLEDB.4.0;Data Source = C:\\Users\\three\\Desktop\\ТехнологияПрограммирования\\ТехнологияПрограммирования\\mas1.mdb");
               MessageBox.Show("БД успешно создана");
           }
           catch (System.Runtime.InteropServices.COMException sit)
           {
               MessageBox.Show(sit.Message);
           }
           finally
           {
               k = null;
           }
       }

       public static void add_structdouble()
       {
           var p = new OleDbConnection("Provider= Microsoft.Jet.OLEDB.4.0;Data Source = C:\\Users\\three\\Desktop\\ТехнологияПрограммирования\\ТехнологияПрограммирования\\mas1.mdb");
           p.Open();
           var r = new OleDbCommand("DELETE FROM [MASSIVS]", p);
           var c = new OleDbCommand("CREATE TABLE [MASSIVS] ([Номер элемента] counter, [Исходный массив] char (200), [Результирующий массив] char (200))", p);
           try
           {
               c.ExecuteNonQuery();
               MessageBox.Show("Структура БД записана", "Информация", MessageBoxButtons.OK, MessageBoxIcon.None);

           }
           catch (System.Runtime.InteropServices.COMException sit)
           {
               MessageBox.Show(sit.Message);
           }
           p.Close();
       }


       public static void add_zap_double(ref int[] mass, int len)
       {
           for (int i = 0; i < len; i++)
           {
               var p = new OleDbConnection("Provider= Microsoft.Jet.OLEDB.4.0;Data Source = C:\\Users\\three\\Desktop\\ТехнологияПрограммирования\\ТехнологияПрограммирования\\mas1.mdb");
               p.Open();
               var r = new OleDbCommand("DELETE FROM [MASSIVS]", p);
               r.Connection = p;
               r.ExecuteNonQuery();

              
               
              
               
                   var c = new OleDbCommand("INSERT INTO [MASSIVS] (" + "[Исходный массив],  VALUES ('" + mass[i] + "', '')");
                   c.Connection = p;
                   c.ExecuteNonQuery();
               
               p.Close();
           }
           MessageBox.Show("В таблицу БД была добавлена запись", "Информация", MessageBoxButtons.OK, MessageBoxIcon.None);
       }
      
        }
       


    }




    

