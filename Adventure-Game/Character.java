/*Eric Grube
 * COP 3330 Section 001
 * Adventure Game Program
 * Character Class
 * 11/7/13
 */

public abstract class Character extends Object implements CaveWorker {
        
        //set the protected variable cave location
        protected Cave location;
        
        //Make a new character at the initial location and mark it as occupied
        public Character(Cave initialLocation) {                
                location = initialLocation;
                location.setOccupied(true);                
        }
        
        //Find the location of the cave that the character is occupying
        public Cave getLocation() {                
                return this.location;                
        }
        
        //Take this character from their current location and move to the new location and then
        //mark the old spot as unoccupied and the new spot as being occupied.
        public boolean move(Cave to) {                
                this.location.setOccupied(false);
                this.location = to;
                this.location.setOccupied(true);
                
                return true;                
        }
        
        //This abstract method gets the name of the character
        public abstract String getName();
}
