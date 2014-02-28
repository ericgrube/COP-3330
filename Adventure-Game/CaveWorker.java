/*Eric Grube
 * COP 3330 Section 001
 * Adventure Game Program
 * Cave Worker Class
 * 11/7/13
 */

public interface CaveWorker {
        
		//This is the method making modifications to a given cave if the worker can actually modify the type of cave
        boolean modifyCave(Cave location);
        
        //Spit out the description of the type of modification made
        String describeModification();

}
