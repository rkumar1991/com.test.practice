package com.knap.divisible;

public class KnapDivisible {

	public static void main(String[] args) {
		int []arrayProfit={10,5,15,7,6,18,3};
		int []arrayWeight={2,3,5,7,1,4,1};
		float arrayProfitPerWeight[]=new float [arrayProfit.length];
		
		for(int i=0;i<arrayProfit.length;i++){
			int a=arrayProfit[i];
			float b = arrayWeight[i];
			
			arrayProfitPerWeight[i]=a/b;
		}
		//sor profitPerWeight in natural order
		
		for(int i=0;i<arrayProfitPerWeight.length;i++){
			int min=i;
			for(int j=i+1;j<arrayProfitPerWeight.length;j++){
				if(arrayProfitPerWeight[min]<arrayProfitPerWeight[j]){
					min=j;
				}
			}
			float temp=arrayProfitPerWeight[i];
			arrayProfitPerWeight[i]=arrayProfitPerWeight[min];
			arrayProfitPerWeight[min]=temp;
			
			int temp1=arrayProfit[i];
			arrayProfit[i]=arrayProfit[min];
			arrayProfit[min]=temp1;
			
			temp1=arrayWeight[i];
			arrayWeight[i]=arrayWeight[min];
			arrayWeight[min]=temp1;
		}
		
		for(int i=0;i<arrayProfit.length;i++){
			System.out.print(arrayProfit[i]+" ");
		}
		System.out.println();
		for(int i=0;i<arrayWeight.length;i++){
			System.out.print(arrayWeight[i]+" ");
		}
		System.out.println();
		for(int i=0;i<arrayProfitPerWeight.length;i++){
			System.out.print(arrayProfitPerWeight[i]+" ");
		}
//calculating Maximum profit
		int profit=0;
		int w=0;
		int c=15;
		for(int i=0;i<arrayProfitPerWeight.length;i++){
			int temWeight=w;
				w+=arrayWeight[i];
				if(c-w>=0){
				profit+=arrayProfit[i];
			}
				else
				{
					if(c-w<0){
						profit+=arrayProfitPerWeight[i]*(c-temWeight);
					}
					break;
				}
		}
		System.out.println();
		System.out.println(profit);
		System.out.println(w);
	}

}
