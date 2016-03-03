package tr.org.liderahenk.lider.impl.userSession;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tr.org.liderahenk.lider.core.api.agent.IAgent;
import tr.org.liderahenk.lider.core.api.agent.IUserSession;
import tr.org.liderahenk.lider.core.api.agent.SessionEvent;
import tr.org.liderahenk.lider.core.api.agent.dao.IAgentDao;
import tr.org.liderahenk.lider.core.api.messaging.IUserSessionMessage;
import tr.org.liderahenk.lider.core.api.messaging.IUserSessionSubscriber;

/**
 * <p>
 * Provides default user login/logout event handler in case no other bundle
 * provides its user session subscriber.
 * </p>
 * 
 * @author <a href="mailto:emre.akkaya@agem.com.tr">Emre Akkaya</a>
 * @see tr.org.liderahenk.lider.core.api.messaging.IUserSessionSubscriber
 * @see tr.org.liderahenk.lider.core.api.messaging.IUserSessionMessage
 *
 */
public class DefaultUserSessionSubscriber implements IUserSessionSubscriber {

	private static Logger logger = LoggerFactory.getLogger(DefaultUserSessionSubscriber.class);

	private IAgentDao agentDao;

	@Override
	public void messageReceived(IUserSessionMessage message) throws Exception {

		String uid = message.getFrom().split("@")[0];

		// Find related agent record
		List<? extends IAgent> agentList = agentDao.findByProperty("jid", uid, 1);
		IAgent agent = agentList.get(0);

		// Add new user session info
		IUserSession userSession = createUserSession(message);
		agent.addUserSession(userSession);

		// Merge records
		agentDao.update(agent);

		logger.info("Added new user session detail to agent: {}", agent);
	}

	private IUserSession createUserSession(final IUserSessionMessage message) {
		IUserSession userSession = new IUserSession() {

			private static final long serialVersionUID = -5042342747639817160L;

			@Override
			public Long getId() {
				return null;
			}

			@Override
			public IAgent getAgent() {
				return null;
			}

			@Override
			public String getUsername() {
				return message.getUsername();
			}

			@Override
			public SessionEvent getSessionEvent() {
				// Session event must be LOGIN or LOGOUT
				switch (message.getType()) {
				case LOGIN:
					return SessionEvent.LOGIN;
				case LOGOUT:
					return SessionEvent.LOGOUT;
				default:
					return null;
				}
			}

			@Override
			public Date getCreationDate() {
				return message.getTimestamp();
			}

		};

		return userSession;
	}

	public void setAgentDao(IAgentDao agentDao) {
		this.agentDao = agentDao;
	}

}
