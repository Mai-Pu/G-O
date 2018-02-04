import java.util.*;
public class go {

	public static void main(String[] args) {
		double []t={0.0,11.0,12.0,13.0,14.0,15.0,16.0,17.0,18.0,19.0,20.0};
		double []y={0.0,268.0,290.0,331.0,375.0,411.0,425.0,433.0,444.0,448.0,460.0};
		double time;
		double Rt;
		double R;
		double x;
		int n=10;
		double a,b;
		double fa=0.0;
		double fb=0.0;
		double m=50000000.0;
		double m1;
		double m2;
		double m3=0.0;
		double m4;
		double m5;
		int i;
		Scanner in=new Scanner(System.in);
		System.out.println("please enter time: ");
		time=in.nextDouble();
		System.out.println("please enter 所需可靠度: ");
		R=in.nextDouble();
		System.out.println("please enter x(x为计算[time,time+x]区间的可靠度): ");
		x=in.nextDouble();
		in.close();
		for(b=0.001;b<=1;b+=0.001)
		{
			m3=0.0;
			m4=0.0;
			for(i=1;i<=n;i++)
			{
				m1=(y[i]-y[i-1])*(t[i]/Math.exp(b*t[i])-t[i-1]/Math.exp(b*t[i-1]));
				m2=1.0/Math.exp(b*t[i-1])-1.0/Math.exp(b*t[i]);
				m3+=m1/m2;
			}
			a=y[n]/(1-1/Math.exp(b*t[n]));
			m4=a*t[n]/Math.exp(b*t[n]);
			m5=m3-m4;
			if(m5<0.0)
				m5=0.0-m5;
			if(m5<m)
			{
				m=m5;
				fa=a;
				fb=b;
			}
		}
		a=fa;
		b=fb;
		m=a*(1-1/Math.exp(b*time));
		System.out.print("最终可以被检测到的失效总数的期望："+a+" "+"剩余失效发现率："+b);
		System.out.print("\n");
		System.out.print("time时刻累计失效数的期望："+m+"\n");
		Rt=1/Math.exp(a*(1/Math.exp(b*time)-1/Math.exp(b*time+b*x)));
		System.out.println("[time,time+x]区间的可靠度: "+Rt+"\n");
		time=1/b*(Math.log(a*(1-1/Math.exp(b*x)))-Math.log(Math.log(1/R)));
		System.out.println("得到区间[t,t+x]可靠度为R所需的时刻t: "+time+"\n");
	}


}

