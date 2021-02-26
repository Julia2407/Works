public class point3D {


   double xCoord; //координата X
   double yCoord; //координата Y
   double zCoord; //координата Z

    
    

    public point3D ( double x, double y, double z) { /* конструктор
        инициализации переменных */
        xCoord = x;
        yCoord = y;
        zCoord = z;
        }
        public point3D () {
            this(0, 0, 0); /* конструктор по умолчанию
            */
           
        }
        
        
    
        double distanceTo(point3D p) { /*
            расстояие между точками объектов*/ 

            double dx = this.xCoord - p.xCoord;
            double dy = this.yCoord - p.yCoord;
            double dz = this.zCoord - p.zCoord;
            
            return Math.sqrt(dx*dx + dy*dy + dz*dz);
            
            }
            
        public double getX () { /*возвращает значение координаты x*/
            return xCoord;
            }
            public double getY () { /*возвращает значение координаты y*/ 
                return yCoord;
                }
                public double getZ () { /*возвращает значение
                     координаты z */
                    return zCoord;
                    }
                    public void setX ( double val) { /*установка
                        значения */
                       xCoord = val;
                       }
                       public void setY ( double val) { 
                       yCoord = val;
                       }
                       public void setZ ( double val) { 
                       zCoord = val;
                       } 
}

 
