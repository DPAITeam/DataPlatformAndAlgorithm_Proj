package cluster;

import algorithmSuminter.Inter_Algorithm_Total;
import algorithmSuminter.Result;

public class knnImp implements knn,Inter_Algorithm_Total
{
	private StringBuffer buf = null;
	private int demission = 0;
    public knnImp()
    {
    	
    	System.out.println("good");
    }
    
	@Override
	public void train() {
		// TODO Auto-generated method stub
		System.out.println("very good");
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Result ans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(StringBuffer buf, int demission) {
		// TODO Auto-generated method stub
		this.buf = buf;
		this.demission =demission;
	}

}
