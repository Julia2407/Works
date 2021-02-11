using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Подпрограммы;

namespace Экзамен
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
           
            double g = Class1.vvod(textBox1);
            int n = Convert.ToInt16(g);
            int[] massArr1 = new int[n];
           Class1.enter_array1(n, massArr1);
           Class1.output_mas(n, dataGridView1, massArr1);
           int N = 0;
           Class1.ChangeMass(n, ref N, massArr1);
           int[] Resmas = new int[N];
           Class1.Newmass(n, N, massArr1, Resmas);
           Class1.output_mas(N, dataGridView2, Resmas);
           Class1.add_structdouble();
           Class1.add_zap_double(ref Resmas, N);
           Class1.Add_toNotebook(ref Resmas, N);
          
        }
    }
}
