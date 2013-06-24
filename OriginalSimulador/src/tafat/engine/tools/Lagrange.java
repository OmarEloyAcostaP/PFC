package tafat.engine.tools;

// Lagrange.java  build for n points, evaluate, integrate 
//                L_n,j(x) = product i=0,n i!=j (x-x_i)/(x_j-x_i)  
//                let  x   be points x_0, x_1, ... , x_n
//                L_n(x) = sum j=0,n f(x_j) L_n,j(x)
//                This L_n(x) fits f(x) with a  n-th order polynomial

public class Lagrange
{

  double[] L;
  int numberPoints;
	
  public Lagrange(double X[], double Y[])
  {
	this.numberPoints = X.length;
    int n = this.numberPoints-1; // np is power, zero base subscripts 0..n points
    L = new double [this.numberPoints];
    double termx, termc;
    double q[] = new double[n+1]; // temp
    double p[] = new double[n+1]; // temp

    for(int j=0; j<=n; j++) L[j] = 0.0;
    for(int j=0; j<=n; j++)
    {
      p[0] = 1.0; // identity polynomial to start product
      for(int i=1; i<=n; i++) p[i] = 0.0;
      for(int i=0; i<=n; i++)
      {
        if(i!=j)
        {
	  termx = 1.0/(X[j]-X[i]); // (x    )/(x_j-x_i) 
          termc = -X[i]*termx;     // ( -x_i)/(x_j-x_i)
          // do product p[] * (termx * x + termc) 
          for(int k=0; k<=n; k++) q[k] = p[k] * termc;
          for(int k=1; k<=n; k++) q[k] = q[k] + p[k-1]*termx;
          for(int k=0; k<=n; k++) p[k] = q[k];
        }
      }
      for(int k=0; k<=n; k++) L[k] = L[k]+Y[j]*p[k];
    } // end loop on j 
  } // end constructor Lagrange

  public double evaluate(double X)
  {
    int n = this.numberPoints - 1; // zero base indexing
    double Y;

    Y = L[n]*X;
    for(int i=n-1; i>0; i--) Y = (L[i]+Y)*X;
    Y = Y + L[0];
    return Y;
  } // end evaluate
} // end class Lagrange
 
