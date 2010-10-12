package com.subgraph.vega.impl.scanner.modules.scripting;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

import com.subgraph.vega.api.scanner.model.IScanModel;
import com.subgraph.vega.api.scanner.modules.IResponseProcessingModule;

public class ResponseProcessorScript extends AbstractScriptModule implements IResponseProcessingModule {

	public ResponseProcessorScript(ScriptedModule module) {
		super(module);
	}
	
	@Override
	public void processResponse(HttpRequest request, HttpResponse response,
			IScanModel scanModel) {
		export("httpRequest", request);
		export("httpResponse", response);
		export("scanModel", scanModel);
		runScript();
	}

	@Override
	public boolean responseCodeFilter(int code) {
		return true;
	}

	@Override
	public boolean mimeTypeFilter(String mimeType) {
		return true;
	}

}