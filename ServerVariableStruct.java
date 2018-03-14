public class ServerVariableStruct 
{
    //Server Variable Struct
    //true = open
    //false = closed
   public boolean doorN1 = true,doorN2 = true,doorN3 = true,doorN4 = true;
   public boolean quad1 = true,quad3 = true,quad4 = true;
   public boolean  waiting = true, waitingSent = false;
   public int vx = 0, vy = 0, px = 0, py = 0, cx = 0, cy = 0, nx = 0, ny = 0;
   public int bx =0, by = 0, jx = 0, jy = 0, tx = 0, ty = 0;
   
   ServerVariableStruct()
   {
   }  
}
