package ui;

import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.FilePath;
import com.intellij.openapi.vcs.VcsDataKeys;
import com.intellij.openapi.vcs.changes.Change;
import com.intellij.openapi.vcs.changes.ChangesUtil;
import com.intellij.openapi.vcs.changes.ui.SimpleChangesBrowser;
import com.intellij.openapi.vcs.changes.ui.VcsTreeModelData;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import static com.intellij.openapi.vcs.VcsDataKeys.SELECTED_CHANGES;

public class MySimpleChangesBrowser extends SimpleChangesBrowser {

    public MySimpleChangesBrowser(@NotNull Project project, @NotNull Collection<? extends Change> changes) {
        super(project, changes);
    }

    protected void onDoubleClick() {

        // Receive the selected VirtualFile (as array)
        VirtualFile[] virtualFileStream = (VirtualFile[]) VcsTreeModelData.getData(myProject, myViewer, "virtualFileArray");

        if (virtualFileStream == null) {
            return;
        }

        for (VirtualFile virtualFile : virtualFileStream) {
            // Open the file
            new OpenFileDescriptor(myProject, virtualFile, 0, 0, false).navigate(true);
            return;
        }

    }

}
