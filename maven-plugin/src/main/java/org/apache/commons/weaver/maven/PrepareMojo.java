/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.weaver.maven;

import java.io.File;
import java.util.List;

import org.apache.maven.model.Build;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

/**
 * Goal to clean woven classes.
 */
@Mojo(
    name = "prepare",
    defaultPhase = LifecyclePhase.INITIALIZE,
    requiresDependencyCollection = ResolutionScope.COMPILE
)
public class PrepareMojo extends AbstractPrepareMojo {
    /**
     * {@link MavenProject#getCompileClasspathElements()}.
     */
    @Parameter(readonly = true, required = true, defaultValue = "${project.compileClasspathElements}")
    protected List<String> classpath;

    /**
     * {@link Build#getOutputDirectory()}.
     */
    @Parameter(readonly = true, required = true, defaultValue = "${project.build.outputDirectory}")
    protected File target;

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<String> getClasspath() {
        return classpath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected File getTarget() {
        return target;
    }

}
