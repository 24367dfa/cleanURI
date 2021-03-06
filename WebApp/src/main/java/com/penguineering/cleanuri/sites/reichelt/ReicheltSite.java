/*
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
package com.penguineering.cleanuri.sites.reichelt;

import net.jcip.annotations.ThreadSafe;

import com.penguineering.cleanuri.CachingExtractor;
import com.penguineering.cleanuri.Site;
import com.penguineering.cleanuri.api.Canonizer;
import com.penguineering.cleanuri.api.Extractor;

/**
 * Site implementation for reichelt.de.
 * 
 * @author Tux (tux@netz39.de)
 * 
 */
@ThreadSafe
public class ReicheltSite implements Site {
	public static final String PREFIX = "http://www.reichelt.de/index.html?ARTICLE=";

	public static ReicheltSite getInstance() {
		return new ReicheltSite();
	}

	private final Canonizer canonizer;
	private final Extractor extractor;

	private ReicheltSite() {
		this.canonizer = new ReicheltCanonizer();
		this.extractor = CachingExtractor.forExtractor(new ReicheltExtractor());
	}

	@Override
	public String getId() {
		return "Reichelt";
	}

	@Override
	public String getLabel() {
		return "Site transformer for reichelt.de";
	}

	@Override
	public Canonizer getCanonizer() {
		return this.canonizer;
	}

	@Override
	public Extractor getExtractor() {
		return this.extractor;
	}

}
