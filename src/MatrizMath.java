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
	
}
