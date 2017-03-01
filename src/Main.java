import util_all.C_Matrix;
import util_all.Inter_Matrix;


public class Main {

	public static void main(String[] args) {
		double[][] a = new double[4][4];
		a[0][0] = 1;a[0][1]=0;a[0][2]=2;a[0][3]=1;
		a[1][0] = 2;a[1][1]=1;a[1][2]=3;a[1][3]=0;
		a[2][0] = 1;a[2][1]=1;a[2][2]=0;a[2][3]=2;
		a[3][0] = 2;a[3][1]=0;a[3][2]=1;a[3][3]=3;
		Inter_Matrix cx = new C_Matrix(a,4,4);
		cx.inverse_Matrix();
		cx.print();
		

	}

}
