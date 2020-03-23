package implementation.scope;

import com.intellij.openapi.vcs.changes.Change;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.scope.packageSet.NamedScopesHolder;
import com.intellij.psi.search.scope.packageSet.PackageSet;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public class MyPackageSet implements PackageSet {

    private Collection<Change> changes;

    public void setChanges(Collection<Change> changes) {
        this.changes = changes;
    }

    @Override
    public boolean contains(@NotNull PsiFile file, NamedScopesHolder holder) {

        if (this.changes == null) {
            return false;
        }

        VirtualFile vFile = file.getVirtualFile();

        for (Change change : this.changes) {

            VirtualFile vFileOfChanges = change.getVirtualFile();

            if (vFileOfChanges == null) {
                continue;
            }

            if (Objects.equals(vFile, vFileOfChanges)) {
                return true;
            }

        }

        return false;

    }

    @NotNull
    @Override
    public PackageSet createCopy() {
        return null;
    }

    @NotNull
    @Override
    public String getText() {
        return "";
    }

    @Override
    public int getNodePriority() {
        return 0;
    }
}
