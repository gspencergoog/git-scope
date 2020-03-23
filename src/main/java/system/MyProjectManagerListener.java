package system;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import implementation.Manager;

public class MyProjectManagerListener implements ProjectManagerListener {

    public void projectOpened(Project project) {

        //Manager manager = new Manager();
        Manager manager = ServiceManager.getService(project, Manager.class);
        manager.init(project);

    }

}