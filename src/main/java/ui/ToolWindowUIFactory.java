package ui;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import implementation.Manager;
import org.jetbrains.annotations.NotNull;

public class ToolWindowUIFactory implements ToolWindowFactory {

    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

        // Even on Start, or on open toolWindow

        Manager manager = ServiceManager.getService(project, Manager.class);
//        manager.createToolwindowUI(project);
//        ToolWindowUI toolWindowUI = manager.getToolWindowUI();
        ToolWindowUI toolWindowUI = new ToolWindowUI(
                project,
                manager.getGit(),
                manager
        );
        manager.setToolWindowUI(toolWindowUI);

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(toolWindowUI.getRootPanel(), "", false);
        toolWindow.getContentManager().addContent(content);

    }

}