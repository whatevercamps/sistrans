package startup;

import javax.jms.JMSException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dtm.RotondAndesDistributed;


@WebListener
public class ContextListener implements ServletContextListener {

	private RotondAndesDistributed dtm;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		try {
			dtm.stop();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		final ServletContext context = arg0.getServletContext();
		RotondAndesDistributed.setPath(context.getRealPath("WEB-INF/ConnectionData"));
		dtm = RotondAndesDistributed.getInstance();
	}

}