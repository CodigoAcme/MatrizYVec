import java.util.Scanner;

public class MatrizMath {

	private int col;
	private int fil;
	private int[][] matriz;
	
	public MatrizMath(){
		col = 0;
		fil  = 0;
	}
	
	public MatrizMath(MatrizMath mat){
		this.col = mat.col;
		this.fil = mat.fil;
		for(int i = 0; i<this.fil;i++){
			for(int j = 0; j<this.col;j++){
				this.matriz[i][j] = mat.matriz[i][j];
			}
		}
	}
	
	public MatrizMath(String path){
		Scanner sc = new Scanner(path+"Matriz.in");
		int colAct, filAct;
		this.fil = sc.nextInt();
		this.col = sc.nextInt();
		while(sc.hasNextInt()){
			filAct = sc.nextInt();
			colAct = sc.nextInt();
			this.matriz[filAct][colAct] = sc.nextInt();
		}
		sc.close();
	}
	
	public MatrizMath sumaMath(MatrizMath mat){
		MatrizMath matRes = new MatrizMath();
		for(int i = 0; i<this.fil;i++){
			for(int j = 0; j<this.col;j++){
				matRes.matriz[i][j] = this.matriz[i][j] + mat.matriz[i][j];
			}
		}
		matRes.fil = this.fil;
		matRes.col = this.col;
		return matRes;
	}
	
	public MatrizMath restaMath(MatrizMath mat){
		MatrizMath matRes = new MatrizMath();
		for(int i = 0; i<this.fil;i++){
			for(int j = 0; j<this.col;j++){
				matRes.matriz[i][j] = this.matriz[i][j] - mat.matriz[i][j];
			}
		}
		matRes.fil = this.fil;
		matRes.col = this.col;
		return matRes;
	}
	
	public MatrizMath productoMath(MatrizMath mat){
		MatrizMath matRes = new MatrizMath();
		for(int i = 0; i<this.fil;i++){
			for(int j = 0; j<mat.col;j++){
				matRes.matriz[i][j] = 0;
				for(int k = 0; k<this.col; k++)
				matRes.matriz[i][j] += this.matriz[i][k] - mat.matriz[k][j];
			}
		}
		matRes.fil = this.fil;
		matRes.col = this.col;
		return matRes;
	}
	public VectorMath productoVec(VectorMath vec){
		VectorMath vecRes = new VectorMath();
		double[] vector = null;
		for(int i = 0; i<this.fil;i++){
			vector[i] = 0;
			for(int j = 0; j<this.col; j++){
				vector[i] += vec.getVector()[j] * this.matriz[j][i];
			}
		}
		return vecRes;
		
	}
	
	public double[][] inverz_matriz(){
		int st_vrs=this.matriz.length, st_stolp=this.matriz[0].length;
		double[][]out=new double[st_vrs][st_stolp];
		double[][]old=new double[st_vrs][st_stolp*2];
		double[][] nueva=new double[st_vrs][st_stolp*2];

		
		for (int v=0;v<st_vrs;v++){//ones vector
			for (int s=0;s<st_stolp*2;s++){
				if (s-v==st_vrs) 
					old[v][s]=1;
				if(s<st_stolp)
					old[v][s]=this.matriz[v][s];
			}
		}
		//zeros below the diagonal
		for (int v=0;v<st_vrs;v++){
			for (int v1=0;v1<st_vrs;v1++){
				for (int s=0;s<st_stolp*2;s++){
					if (v==v1)
						nueva[v][s]=old[v][s]/old[v][v];
					else
						nueva[v1][s]=old[v1][s];
				}
			}
			old=prepisi(nueva);		
			for (int v1=v+1;v1<st_vrs;v1++){
				for (int s=0;s<st_stolp*2;s++){
					nueva[v1][s]=old[v1][s]-old[v][s]*old[v1][v];
				}
			}
			old=prepisi(nueva);
		}
		//zeros above the diagonal
		for (int s=st_stolp-1;s>0;s--){
			for (int v=s-1;v>=0;v--){
				for (int s1=0;s1<st_stolp*2;s1++){
					nueva[v][s1]=old[v][s1]-old[s][s1]*old[v][s];
				}
			}
			old=prepisi(nueva);
		}
		for (int v=0;v<st_vrs;v++){//rigt part of matrix is invers
			for (int s=st_stolp;s<st_stolp*2;s++){
				out[v][s-st_stolp]=nueva[v][s];
			}
		}
		return out;
	}

	public static double[][] prepisi(double[][]in){
		double[][]out=new double[in.length][in[0].length];
		for(int v=0;v<in.length;v++){
			for (int s=0;s<in[0].length;s++){
				out[v][s]=in[v][s];
			}
		}
		return out;
	}
	
}
