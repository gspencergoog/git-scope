package implementation.scope;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.changes.Change;
import com.intellij.psi.search.scope.packageSet.NamedScope;
import com.intellij.psi.search.scope.packageSet.NamedScopeManager;
import com.intellij.util.ArrayUtil;
import system.Defs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyScope {

    public static final String OLD_SCOPE_NAME = Defs.APPLICATION_NAME + " (Files)";
    public static final String SCOPE_NAME = Defs.APPLICATION_NAME;

    private final Project project;
    private final NamedScopeManager scopeManager;
    private MyPackageSet myPackageSet;

    public MyScope(Project project) {

        this.project = project;
        this.scopeManager = NamedScopeManager.getInstance(this.project);

        this.createScope();

    }

    public void createScope() {
        this.myPackageSet = new MyPackageSet();
        NamedScope myScope = new NamedScope(SCOPE_NAME, this.myPackageSet);
        boolean scopeExists = false;

        NamedScope[] scopes = this.scopeManager.getEditableScopes();
        NamedScope[] newNamedScopes = new NamedScope[0];

        for (NamedScope scope : scopes) {
            if (SCOPE_NAME.contentEquals(scope.getName())) {
                scopeExists = true;
                scope = myScope;
            }
            // @todo Delete in newer Versions after some time
            if (OLD_SCOPE_NAME.contentEquals(scope.getName())) {
                continue;
            }
            newNamedScopes = ArrayUtil.append(newNamedScopes, scope);
        }

        if (!scopeExists) {
            newNamedScopes = ArrayUtil.append(newNamedScopes, myScope);
        }

        this.scopeManager.setScopes(newNamedScopes);

    }

    public void update(Collection<Change> changes){
        this.myPackageSet.setChanges(changes);
    }

}
