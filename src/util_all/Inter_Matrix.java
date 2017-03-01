package util_all;

public interface Inter_Matrix {
	//矩阵乘法
	public abstract Inter_Matrix multiply(Inter_Matrix x);
	public abstract Inter_Matrix multiply(Inter_Matrix x,Inter_Matrix y);
	
	//矩阵数乘
	public abstract Inter_Matrix num_Multiply(double x);
	public abstract Inter_Matrix num_Multiply(Inter_Matrix x,double y);
	
	//矩阵的快速幂
	public abstract Inter_Matrix pow(Inter_Matrix x,int num);
	public abstract Inter_Matrix pow(int num);
	
	//矩阵的加法
	public abstract Inter_Matrix add(Inter_Matrix x);
	public abstract Inter_Matrix add(Inter_Matrix x,Inter_Matrix y);
	
	//矩阵的多次加
	public abstract Inter_Matrix add_multiple(Inter_Matrix x,int num);
	public Inter_Matrix add_multiple(int num);
	
	//矩阵的减法
    public abstract Inter_Matrix subtract(Inter_Matrix x);
    public abstract Inter_Matrix subtract(Inter_Matrix x,Inter_Matrix y);
    
    //矩阵的转置
    public abstract Inter_Matrix transpose(Inter_Matrix x);
    public abstract Inter_Matrix transpose();
    
    //矩阵的逆
    public abstract Inter_Matrix inverse_Matrix();
    
    //矩阵的分拆
    public abstract Inter_Matrix[] split_Matrix(int n,int m);
    
    //矩阵的合并
    public abstract Inter_Matrix   combine_Matrix(Inter_Matrix[] x);
    
    //获得矩阵的列数
	public abstract int getM();
	
	//获得矩阵的列数
	public abstract int getN();
	
	//获得矩阵的元素
	public abstract double getAij(int i,int j);
	
	//设置矩阵中i,j元素的值为tp
	public abstract void setAij(double tp, int i,int j);
	
	//打印矩阵
	public abstract void print();
}
