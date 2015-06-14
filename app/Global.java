import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTML.Tag;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {
	@Override
	public void onStart(Application app) {
		Logger.info("Application has stared");
//		IntialData.insert(app);
	}

	static class IntialData {
		public static void insert(Application app) {
			if (Ebean.find(Tag.class).findRowCount() == 0) {
				Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml
						.load("initial-data.yml");
				Ebean.save(all.get("tags"));
			}
		}
	}

	@Override
	public void onStop(Application app) {
		Logger.info("Application shutdown...");
	}
}
