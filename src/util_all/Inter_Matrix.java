package util_all;

public interface Inter_Matrix {
	//����˷�
	public abstract Inter_Matrix multiply(Inter_Matrix x);
	public abstract Inter_Matrix multiply(Inter_Matrix x,Inter_Matrix y);
	
	//��������
	public abstract Inter_Matrix num_Multiply(double x);
	public abstract Inter_Matrix num_Multiply(Inter_Matrix x,double y);
	
	//����Ŀ�����
	public abstract Inter_Matrix pow(Inter_Matrix x,int num);
	public abstract Inter_Matrix pow(int num);
	
	//����ļӷ�
	public abstract Inter_Matrix add(Inter_Matrix x);
	public abstract Inter_Matrix add(Inter_Matrix x,Inter_Matrix y);
	
	//����Ķ�μ�
	public abstract Inter_Matrix add_multiple(Inter_Matrix x,int num);
	public Inter_Matrix add_multiple(int num);
	
	//����ļ���
    public abstract Inter_Matrix subtract(Inter_Matrix x);
    public abstract Inter_Matrix subtract(Inter_Matrix x,Inter_Matrix y);
    
    //�����ת��
    public abstract Inter_Matrix transpose(Inter_Matrix x);
    public abstract Inter_Matrix transpose();
    
    //�������
    public abstract Inter_Matrix inverse_Matrix();
    
    //����ķֲ�
    public abstract Inter_Matrix[] split_Matrix(int n,int m);
    
    //����ĺϲ�
    public abstract Inter_Matrix   combine_Matrix(Inter_Matrix[] x);
    
    //��þ��������
	public abstract int getM();
	
	//��þ��������
	public abstract int getN();
	
	//��þ����Ԫ��
	public abstract double getAij(int i,int j);
	
	//���þ�����i,jԪ�ص�ֵΪtp
	public abstract void setAij(double tp, int i,int j);
	
	//��ӡ����
	public abstract void print();
}
