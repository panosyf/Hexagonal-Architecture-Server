package com.hexagonal.architecture.server.modules;

import com.hexagonal.architecture.server.HexagonalArchitectureServerApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModuleArchitectureTest {

    ApplicationModules modules = ApplicationModules.of(HexagonalArchitectureServerApplication.class);

    @Test
    @Disabled
    void verifyModuleArchitecture() {
        modules.verify();
    }

    @Test
    void documentModuleDependencyDiagram() {
        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

}
