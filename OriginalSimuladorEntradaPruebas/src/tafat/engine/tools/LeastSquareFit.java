package tafat.engine.tools;

// LeastSquareFit.java
//
// Given a set of pairs x[i], y[i] for y[i]=F(x[i]) i=0,n-1
// Find the least square fit polynomial coefficients c[i]
// of polynomial P(x)=c[0]+c[1]*x+c[2]*x^3+c[3]*x^3+...
// that minimize sum( (y[i]-P(x[i]))^2 )
//
// Method: build matrix A, vector Y and solve for vector C
// A*C=Y  where all sum's are over i=0,n-1 the x,y points
// r is the order of the approximating polynomial, max(r)=n
//
//     | sum(1.0)      sum(x[i]^1) sum(x[i]^2)   ... sum(x[i]^r-1)  |
//     | sum(x[i]^1)   sum(x[i]^2) sum(x[i]^3)   ... sum(x[i]^r)    |
// A = | sum(x[i]^2)   sum(x[i]^3) sum(x[i]^4)   ... sum(x[i]^r+1   |
//     | ...           ...         ...           ... ...            |
//     | sum(x[i]^r-1) sum(x[i]^r) sum(x[i]^r+1) ... sum(x[i]^2r-1) |
//
//     | sum(y[i])            |
//     | sum(x[i]^1 * y[i])   |
// Y = | sum(x[i]^2 * y[i])   |
//     | ...                  |
//     | sum(x[i]^r-1 * y[i]) |


public strictfp class LeastSquareFit
{
  double c[]; // the coefficients of the fit
  
  public LeastSquareFit(double x[], double y[]) // constructs c's
  {
    int n = x.length;
    c = new double[n+1];
    if(y.length!=n)
    {
      System.out.println("Error in L.S.Fit inconsistent lengths.");
    }
    LSFit(x, y, n);
  }
  
  public LeastSquareFit(double x[], double y[], int order) // constructs c's
  {
    int n = x.length;
    if(y.length!=n)
    {
      System.out.println("Error in L.S.Fit inconsistent lengths.");
    }
    if(order>n) order=n; // local copy of order
    c = new double[order+1];
    LSFit(x, y, order);
  }
  
  private void LSFit(double x[], double y[], int order)
  {
    int n=x.length;
    double A[][] = new double[order+1][order+1];
    A[0][0] = (double)n;
    double Y[]   = new double[order+1];
    Y[0] = vecSum(y);
    double XP[]  = new double[n];
    double sum;
    
    Matrix.copy(x, XP);
    for(int k=0; k<=2*order-1; k++)
    {
      if(k<order) // compute Y[k+1]
      {
        sum = 0.0;
        for(int j=0; j<n; j++)
        {
          sum = sum + XP[j]*y[j];
        }
        Y[k+1] = sum;
      }
      sum = vecSum(XP);
      int ii = Math.max(0, k-order+1);
      int jj = Math.min(k+1, order);
      for(int ij=0; ij<k+2; ij++)
      {
        A[ii][jj] = sum;
        ii++;
        jj--;
        if(ii>order || jj<0) break;
      }
      for(int j=0; j<n; j++) XP[j] = XP[j]*x[j]; 
    }
    Matrix.solve(A, Y, c);
  }

  public double evaluate(double x)
  {
    int n = c.length;
    double val = c[n-1];
    for(int i=n-2; i>=0; i--) val = c[i]+x*val;
    return val;
  }


  static double vecSum(double x[])
  {
    double val = 0.0;
    for(int i=0; i<x.length; i++) val = val+x[i];
    return val;
  }
} // end class LeastSquareFit
