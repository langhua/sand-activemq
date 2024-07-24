/*
 * Copyright 2019 Langhua Tech.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package langhua.activemq.embed;

import org.apache.ofbiz.base.util.Debug;
import org.apache.tomcat.JarScanType;
import org.apache.tomcat.util.scan.StandardJarScanFilter;

public class SandJarScanFilter extends StandardJarScanFilter {
    private static final String module = SandJarScanFilter.class.getName();
    
    public SandJarScanFilter() {
        super();
    }

    @Override
    public boolean check(JarScanType jarScanType, String jarName) {
        boolean result = super.check(jarScanType, jarName);
        Debug.logVerbose("--SandJarScan--" + jarScanType.name() + "--" + jarName + "--" + result, module);
        return result;
    }
}