public class SnakeGame
{
	int width;
	int height;
	int [][] food;
	int foodPointer;
	int score;
	Node snakeHead;
	Node snakeTail;

	/** Initialize your data structure here.
		@param width - screen width
		@param height - screen height 
		@param food - A list of food positions
		E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	public SnakeGame(int width, int height, int[][] food)
	{
		this.width = width;
		this.height = height;
		this.food = food;
		foodPointer = 0;
		snakeHead = new Node(new int [2], null, null);
		snakeTail = snakeHead;
	}
	
	/** Moves the snake.
		@param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
		@return The game's score after the move. Return -1 if game over. 
		Game over when snake crosses the screen boundary or bites its body. */
	public int move(String direction)
	{
		int [] dir = getDirection(direction.substring(0, 1));

		if(isOver(snakeHead, dir))
			return -1;

		int [] next = new int [2];
		next[0] = snakeHead.coordinate[0] + dir[0];
		next[1] = snakeHead.coordinate[1] + dir[1];

		Node node = new Node(next, null, snakeHead);
		snakeHead.prev = node;
		snakeHead = node;

		if(foodPointer < food.length && next[0] == food[foodPointer][0] && next[1] == food[foodPointer][1])
		{
			foodPointer++;
			return ++score;
		}

		snakeTail = snakeTail.prev;
		snakeTail.next = null;

		return score;
	}

	private int [] getDirection(String x)
	{
		if(x.equals("U"))
			return new int [] {-1, 0};
		else if(x.equals("D"))
			return new int [] {1, 0};
		else if(x.equals("L"))
			return new int [] {0, -1};

		return new int [] {0, 1};
	}

	private boolean isOver(Node node, int [] dir)
	{
		int x = node.coordinate[0] + dir[0];
		int y = node.coordinate[1] + dir[1];

		if(x < 0 || x > height - 1 || y < 0 || y > width - 1)
			return true;

		Node p = node;

		while(p != null)
		{
			if(p.coordinate[0] == x && p.coordinate[1] == y && p != snakeTail)
				return true;

			p = p.next;
		}

		return false;
	}
}
class Node
{
	int [] coordinate;
	Node prev;
	Node next;

	Node(int [] coordinate, Node prev, Node next)
	{
		this.coordinate = coordinate;
		this.coordinate[0] = coordinate[0];
		this.coordinate[1] = coordinate[1];
		this.prev = prev;
		this.next = next;
	}
}