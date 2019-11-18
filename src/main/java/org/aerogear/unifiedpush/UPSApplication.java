/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aerogear.unifiedpush;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * The purpose of this class is to act as a "value object" for the Dashboard services.
 * It contains information about a particular FlatPushMessageInformation instance.
 */
@ApplicationPath("/rest")
public class UPSApplication extends Application{

}
