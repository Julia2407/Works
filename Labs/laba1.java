
public class laba1 {
    public static void main (String [] args) {
       point3D Point1 = new point3D (0,7,3);
       point3D Point2 = new point3D (0,9,8);
       point3D Point3 = new point3D (4,15, -8);
        
        
        if (checkPoints(Point1, Point2, Point3)) //Проверка на совпадение точек
        
        System.out.printf("Area of a triangle: " + "%.2f", computeArea(Point1,Point2, Point3));
        
        else
        
        System.out.println("Some of points are equal. Please, enter correct input data");
        
        }
        
        public static double computeArea (point3D p1, point3D p2, point3D p3) //Вычисление площади треугольника
        
        {
        double a = p1.distanceTo(p2); //Вычисление стороны a
        double b = p2.distanceTo(p3); //Вычисление стороны b
        double c = p3.distanceTo(p1); //Вычисление стороны c
        double per = ((a+b+c)/2); //Вычисление периметра
        return (Math.sqrt(per*(per-a)*(per-b)*(per-c))); //Возвращаемое значение - площадь треугольника по формуле Герона
        
        }
        
        public static boolean checkPoints(point3D p1, point3D p2, point3D p3) //Проверочка на совпадение (равность) точек
        
        {
        
        if ((p1.xCoord == p2.xCoord) && (p1.yCoord == p2.yCoord && (p1.zCoord == p2.zCoord)) ||
        ((p2.xCoord == p3.xCoord && (p2.yCoord == p3.yCoord) && (p2.zCoord == p3.zCoord)) ||
        ((p1.xCoord == p3.xCoord) && (p1.yCoord == p3.yCoord) && (p1.zCoord == p3.zCoord))))
        
        return false;
        
        return true;
        
        }
        
        }



    


