import java.util.Arrays;
import java.util.Scanner;

public class VectorMath {

	private int tam;
	private double[] vector;
	
	public VectorMath(){
		
		tam = 0;
		
	}
	
	
	public VectorMath(VectorMath vec){
		this.tam = vec.tam;
		for(int i=0;i<vec.tam;i++){
			this.vector[i] = vec.vector[i];
		}
	}
	
	public VectorMath(String path){
		
		String linea;
		int i=0;
		int ind = -1;
		Scanner sc = new Scanner(path+"vector.in");
		tam = sc.nextInt();
		while(tam>0){
			
			linea = sc.nextLine();
			ind = linea.indexOf('E');
			if(ind >= 0){
				double num, exp;
				num = Double.valueOf(linea.substring(0, ind));
				exp = Double.valueOf(linea.substring(ind+1));
				vector[i] = Math.pow(num, exp);
			}
			else{
				vector[i] = Double.valueOf(linea);
			}
			i++;
			tam--;
		}
		sc.close();
	}
	
	public VectorMath sumaVecMath(VectorMath vecrec){
		
		VectorMath vec = new VectorMath();
		int tammin, tammax;
		if(vecrec.tam>this.tam){
			tammax = vecrec.tam;
			tammin = this.tam;			
		}
		else{
			tammax = this.tam;
			tammin = vecrec.tam;
		}
		
		vec.tam = tammax;
		
		for(int i = 0; i < tammin; i++){
			vec.vector[i] = this.vector[i] + vecrec.vector[i];
		}
		
		if(this.tam == tammax){
			for(int i = tammin; i < tammax; i++){	
				vec.vector[i] = this.vector[i];
			}
		}
		else{
			for(int i = tammin; i < tammax; i++){	
				vec.vector[i] = vecrec.vector[i];
			}
		}
		return vec;
	}
	
	public VectorMath restaVecMath(VectorMath vecrec){
		
		VectorMath vec = new VectorMath();
		int tammin, tammax;
		if(vecrec.tam>this.tam){
			tammax = vecrec.tam;
			tammin = this.tam;			
		}
		else{
			tammax = this.tam;
			tammin = vecrec.tam;
		}
		
		vec.tam = tammax;
		
		for(int i = 0; i < tammin; i++){
			vec.vector[i] = this.vector[i] - vecrec.vector[i];
		}
		
		if(this.tam == tammax){
			for(int i = tammin; i < tammax; i++){	
				vec.vector[i] = this.vector[i];
			}
		}
		else{
			for(int i = tammin; i < tammax; i++){	
				vec.vector[i] = vecrec.vector[i];
			}
		}
		return vec;
	}
	
	public double productoVecMath(VectorMath vecrec){
		
		double vec = 0;
		int tammin;
		if(vecrec.tam>this.tam){
			tammin = this.tam;			
		}
		else{
			tammin = vecrec.tam;
		}
		
		for(int i = 0; i < tammin; i++){
			vec += this.vector[i] * vecrec.vector[i];
		}
		return vec;
	}
	
	public VectorMath productoReal(double vecrec){
		
		VectorMath vec = new VectorMath();
		vec.tam = this.tam;
		for(int i = 0; i < this.tam; i++){
			vec.vector[i]= this.vector[i] * vecrec;
		}
		return vec;
	}
	
	public int getTam() {
		return tam;
	}


	public void setTam(int tam) {
		this.tam = tam;
	}


	public double[] getVector() {
		return vector;
	}


	public void setVector(double[] vector) {
		this.vector = vector;
	}


	public double NormaUno(){
		
		double vec = 0;
		for(int i = 0; i < this.tam; i++){
			vec += this.vector[i];
		}
		vec = Math.sqrt(vec);
		return vec;
	}
	
	public double NormaDos(){
		
		double vec = 0;
		for(int i = 0; i < this.tam; i++){
			vec += Math.pow(this.vector[i],2);
		}
		vec = Math.sqrt(vec);
		return vec;
	}
	
	public VectorMath clone(){
		VectorMath vec = new VectorMath(this);
		return vec;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tam;
		result = prime * result + Arrays.hashCode(vector);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VectorMath other = (VectorMath) obj;
		if (tam != other.tam)
			return false;
		if (!Arrays.equals(vector, other.vector))
			return false;
		return true;
	}
	
	
	
}
