package com.hexagonal.server.modules;

import com.hexagonal.server.HexagonalServerApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModuleArchitectureTest {

    ApplicationModules modules = ApplicationModules.of(HexagonalServerApplication.class);

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
