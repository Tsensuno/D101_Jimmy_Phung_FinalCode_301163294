package graphics.stars;
import main.Main;

// Used for factory design pattern; this class will instantiate the objects (the factory)
public class StarConcreteCreator extends StarCreator 
{
	public StarConcreteCreator(Main p) 
	{
		super(p);
	}

	@Override
	public AbstractStarTimeObject createStar(int type) 
	{
		AbstractStarTimeObject star = null;
		
		if(type == 1)
		{
			star = new StarHour(p, 1);
		}
		
		if(type == 2)
		{
			star = new StarMinute(p);
		}
		
		return star;
	}
}
