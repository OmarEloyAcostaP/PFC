package tafat.engine.interpolatedfunction;

public class SortHandler {

    public static boolean isSortedNumberList(Coordinate[] coordinates){
    	for (int i = 0; i < coordinates.length - 1; i++) {
			if(coordinates[i].x > coordinates[i + 1].x)
				return false;
		}
    	return true;
    }
	
    public static Coordinate[] sortNumberList(Coordinate[] coordinates) {
    	Coordinate[] aux = coordinates;
        for(int counter=0; counter < aux.length - 1; counter++) {
            for(int index=0; index < aux.length - 1 - counter; index++) {
                if(aux[index].x  > aux[index + 1].x) {
                	Coordinate temp = aux[index];
                	aux[index] = aux[index + 1];
                	aux[index + 1] = temp;
                }
            }
        }
        return aux;
    }
    
}
