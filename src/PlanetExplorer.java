
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 143
// Finish time:16:59

public class PlanetExplorer {
	
	int pos_x = 0;
	int pos_y = 0;
	String facing = "N";
	String position;	
	String check;
	public int x;
	public int y;
	public String obstacles;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		
		this.x = x;
		this.y = y;
		this.obstacles = obstacles;
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		
		
		for(int i=0;i<command.length();i++){
			if(command.substring(i,i+1).equals("l") || command.substring(i,i+1).equals("r")){
				if(command.substring(i,i+1).equals("l")){
					if(facing.equals("N")){
						facing = "W";
					}
					else if(facing.equals("E")){
						facing = "N";
					}
					else if(facing.equals("S")){
						facing = "E";
					}
					else if(facing.equals("W")){
						facing = "S";
					}
				}
				else if(command.substring(i,i+1).equals("r")){
					if(facing.equals("N")){
						facing = "E";
					}
					else if(facing.equals("E")){
						facing = "S";
					}
					else if(facing.equals("S")){
						facing = "W";
					}
					else if(facing.equals("W")){
						facing = "N";
					}
				}	
			}
			else{
				if(command.substring(i,i+1).equals("f")){
					if(facing.equals("N")){
						pos_y++;
						if(pos_y>=y){
							pos_y -= y;
						}
						check = "(" + pos_x + "," + pos_y + ")";
						if(check.equals(obstacles)){
							pos_y--;
							continue;
						}						
					}
					else if(facing.equals("E")){
						pos_x++;
						if(pos_x>=x){
							pos_x -= x;
						}
						check = "(" + pos_x + "," + pos_y + ")";
						if(check.equals(obstacles)){
							pos_x--;
							continue;
						}
					}
					else if(facing.equals("S")){
						pos_y--;
						if(pos_y<0){
							pos_y += y;
						}
						check = "(" + pos_x + "," + pos_y + ")";
						if(check.equals(obstacles)){
							pos_y++;
							continue;
						}
					}
					else if(facing.equals("W")){
						pos_x--;
						if(pos_x<0){
							pos_x += x;
						}
						check = "(" + pos_x + "," + pos_y + ")";
						if(check.equals(obstacles)){
							pos_x++;
							continue;
						}
					}
				}
				else if(command.substring(i,i+1).equals("b")){
					if(facing.equals("N")){
						pos_y--;
						if(pos_y<0){
							pos_y += y;
						}
						check = "(" + pos_x + "," + pos_y + ")";
						if(check.equals(obstacles)){
							pos_y++;
							continue;
						}
					}
					else if(facing.equals("E")){
						pos_x--;
						if(pos_x<0){
							pos_x += x;
						}
						check = "(" + pos_x + "," + pos_y + ")";
						if(check.equals(obstacles)){
							pos_x++;
							continue;
						}
					}
					else if(facing.equals("S")){
						pos_y++;
						if(pos_y>=y){
							pos_y -= y;
						}
						check = "(" + pos_x + "," + pos_y + ")";
						if(check.equals(obstacles)){
							pos_y--;
							continue;
						}
					}
					else if(facing.equals("W")){
						pos_x++;
						if(pos_x>=x){
							pos_x -= x;
						}
						check = "(" + pos_x + "," + pos_y + ")";
						if(check.equals(obstacles)){
							pos_x--;
							continue;
						}
					}
				}
			}
				
		}
		
//		check = "(" + pos_x + "," + pos_y + ")";
		position = "(" + pos_x + "," + pos_y + "," + facing + ")";
		return position;
	}
}
