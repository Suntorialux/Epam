package by.gsu.epamlab.services;

public  class Operations
{
    private enum Operation
    {
    	SUM
            {
                @Override
                double result(double ... numbers)
                { double result=0;
                    for(int i=0;i<numbers.length;i++)
                    {
                        result+=numbers[i];
                    }
                    return result;
                }
            },
        MIN
            {
                @Override
                double result(double ... numbers)
                { 
                    double result=numbers[0];
                    for(int i=1;i<numbers.length;i++)
                    {
                        if(numbers[i]<result)
                        {
                            result=numbers[i];
                        }
                    }
                    return result;
                }
            },
        MAX
            {
                @Override
                double result(double ... numbers)
                {
                    double result=numbers[0];
                    for(int i=1;i<numbers.length;i++)
                    {
                        if(numbers[i]>result)
                        {
                            result=numbers[i];
                        }
                    }
                    return result;
                }
            },
        AVG
            {
                @Override
                double result(double ... numbers)
                {
                    double result=0;
                    for(int i=0;i<numbers.length;i++)
                    {
                        result+=numbers[i];
                    }
                    return result/numbers.length;
                }
            };

        abstract double result(double ... numbers);
    }
    
    public static boolean isDataOk(String... numbers)
    {
        for(int i=0;i<numbers.length;i++)
        {
            try
            {
                Double.parseDouble(numbers[i].trim());
            }
            catch (NumberFormatException e)
            {
                return false;
            }
            
        }
        return true;
    }
    
    public static double getResult(String oper, String... numbers)
    {
        double result = 0.0;
        if(isDataOk(numbers))
        {
            double[] datas=new double[numbers.length];
            for(int i=0;i<numbers.length;i++)
            {
                datas[i]=Double.parseDouble(numbers[i].trim());
            }
            result=Operation.valueOf(oper.toUpperCase()).result(datas);
        }
        return result;
    }
    
    public static StringBuilder printData(String... numbers) {
    	
    	StringBuilder num = new StringBuilder();
		for(String number : numbers) {
			num.append(" ").append(number.trim()).append(",");
		}
		num.deleteCharAt(num.length()-1).deleteCharAt(0);
		return num;
    	
    }
}
