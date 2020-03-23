package system;

import com.intellij.openapi.components.BaseComponent;
import com.intellij.openapi.project.ProjectManager;


public class OnStart implements BaseComponent {

    @Override
    public void initComponent() {

        MyProjectManagerListener myProjectManagerListener = new MyProjectManagerListener();
        ProjectManager.getInstance().addProjectManagerListener(myProjectManagerListener);

    }

}
