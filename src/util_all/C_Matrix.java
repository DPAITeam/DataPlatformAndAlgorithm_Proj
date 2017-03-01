package util_all;

public class C_Matrix implements Inter_Matrix {
	private int n = 0;
	private int m = 0;
	private Inter_Matrix x = null;
	private double[][] a = null;
	private double eps = 1e-8;
	public C_Matrix(){}
    public C_Matrix(int n,int m)
    {
    	this.n=n;
    	this.m=m;
    	this.a = new double[n][m];
    	for(int i=0; i<this.n; i++)
	    	for(int j=0; j<this.m; j++)
               this.a[i][j] = 0.0;
    }
    public C_Matrix(double[][] a,int n,int m)
    {
    	this.m = m;
    	this.n = n;
    	this.a= new double[n][m];
    	for(int i=0; i<this.n; i++)
    		for(int j=0; j<this.m; j++)
    			this.a[i][j] = a[i][j];
    	
    }
	@Override
	public Inter_Matrix multiply(Inter_Matrix x) {
		if(this.m != x.getN())
		{
			System.out.println("error:this cannnot multiply x and this matrix");
			return null;
		}
		double[] tmp = new double[x.getM()];
		for(int i=0; i<this.n; i++)
		{
			for(int j=0; j<x.getM(); j++)
			{
			    tmp[j] = 0.0;
				for(int k=0; k<this.m; k++)
					tmp[j] += this.a[i][k] * x.getAij(k, j);		
			}
			for(int t=0; t<x.getM(); t++)
				this.setAij(tmp[t], i, t);
		}
		return this;
	}

	
	@Override
	public Inter_Matrix multiply(Inter_Matrix x, Inter_Matrix y) {
		
		return null;
	}

	@Override
	public Inter_Matrix num_Multiply(double x) {
		for(int i=0; i<this.n; i++)
			for(int j=0; j<this.m; j++)
				this.setAij(this.getAij(i, j)*x, i, j);;
		return this;
	}

	@Override
	public Inter_Matrix num_Multiply(Inter_Matrix x, double y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inter_Matrix pow(Inter_Matrix x,int num) {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public Inter_Matrix pow(int num) {
		// TODO Auto-generated method stub
		if(this.n != this.m)
		{
			System.out.println("error:this is not a square matrix");
			return null;
		}
		int tnum = num-1;
		Inter_Matrix out = new C_Matrix(this.a,this.n,this.m);
		while(tnum>0)
		{
			if((tnum&1)==1)
				this.multiply(out);
			out.multiply(out);
			tnum >>= 1;	
		}
		return this;
	}
	
	@Override
	public Inter_Matrix add(Inter_Matrix x) {
		if((this.n != x.getN()) || (this.m != x.getM()))
		{
			System.out.println("error:the both matrix is not the same structure!!!");
			return null;
		}
		for(int i=0;i<this.n;i++)
			for(int j=0;j<this.m;j++)
				this.setAij(this.getAij(i, j)+x.getAij(i, j), i, j);
		return this;
	}

	@Override
	public Inter_Matrix add(Inter_Matrix x, Inter_Matrix y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inter_Matrix add_multiple(Inter_Matrix x, int num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Inter_Matrix add_multiple(int num)
	{
		Inter_Matrix out = new C_Matrix(this.a,this.n,this.m);
		num = num-1;
		while(num>0)
		{
			if((num&1)==1)
				this.add(out);
			out.add(out);
			num >>= 1;
		}
		return this;
	}

	@Override
	public Inter_Matrix subtract(Inter_Matrix x) {
		// TODO Auto-generated method stub
		if((this.n != x.getN()) || (this.m != x.getM()))
		{
			System.out.println("error:the both matrix is not the same structure!!!");
			return null;
		}
		for(int i=0;i<this.n;i++)
			for(int j=0;j<this.m;j++)
				this.setAij(this.getAij(i, j) - x.getAij(i, j), i, j);
		return this;
	}

	@Override
	public Inter_Matrix subtract(Inter_Matrix x, Inter_Matrix y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inter_Matrix transpose(Inter_Matrix x) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
	
	@Override
	public Inter_Matrix transpose() {
		// TODO Auto-generated method stub
		Inter_Matrix tmp = new C_Matrix(this.a,this.n,this.m);
		this.a = new double[this.m][this.n];
		int tp =this.n;
		this.n = this.m;
		this.m = tp;
		for(int i=0;i<this.n;i++)
			for(int j=0;j<this.m;j++)
				this.a[j][i] = tmp.getAij(i, j);	
		
		return this;
	}
	@Override
	public Inter_Matrix inverse_Matrix(Inter_Matrix x) {
		// TODO Auto-generated method stub
		if(this.m != this.n)
		{
			System.out.println("this is not square matrix!!!");
			return null;
		}
		Inter_Matrix tmp = new C_Matrix(this.n,2*this.m);
		for(int i=0;i<this.n;i++)
			tmp.setAij(1.0, i, this.m+i);
		for(int i=0;i<this.n;i++)
			for(int j=0; j<this.m;j++)
				tmp.setAij(this.getAij(i, j), i, j);
		
		for(int i=0;i<this.n;i++)
		{
			int next =i;
			while(Math.abs(tmp.getAij(i, i)) <= eps)
			{
				   next++; 
					for(int k=0;k<tmp.getM();k++)
				      tmp.setAij(tmp.getAij(i, k)+tmp.getAij(next, k), i, k);
			}
			
			if(Math.abs(tmp.getAij(i, i)-1.0)>eps)
				for(int j=0;j<tmp.getM();j++)
					tmp.setAij(tmp.getAij(i, j)/tmp.getAij(i, i), i, j);
			for(int j=i+1;j<this.n;j++)
				for(int k=0;k<tmp.getM();k++)
					tmp.setAij(tmp.getAij(j, k)-tmp.getAij(j, i)*tmp.getAij(i, k), j, k);
				
		}
		
		for(int i= this.n-1; i>=0;i--)
		{
			for(int j = i-1; j>=0; j--)
			{
				for(int k=0;k<tmp.getM();k++)
					tmp.setAij(tmp.getAij(j, k)-tmp.getAij(j, i)*tmp.getAij(j, k), j, k);
			}
		}
		
		for(int i=0;i<this.n;i++)
			if(Math.abs(tmp.getAij(i, i))<=eps)
				return null;
		for(int i=0;i<this.n;i++)
			for(int j=0;j<this.m;j++)
			  this.a[i][j] = tmp.getAij(i, j+this.m);
		
		return this;
	}

	@Override
	public Inter_Matrix[] split_Matrix(int n, int m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inter_Matrix combine_Matrix(Inter_Matrix[] x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	
	@Override
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public double[][] getA() {
		return a;
	}
	public void setA(double[][] a) {
		this.a = a;
	}
	
	@Override
	public double getAij(int i,int j)
	{
		return this.a[i][j];
	}
	
	@Override
	public void setAij(double tp, int i,int j)
	{
	    this.a[i][j]= tp;
	}

}
