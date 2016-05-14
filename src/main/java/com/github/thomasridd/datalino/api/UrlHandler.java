package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.NotFound;
import com.github.davidcarboni.restolino.json.Serialiser;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UrlHandler implements NotFound {

  @Override
  public Object handle(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.addHeader("Access-Control-Allow-Origin", "*");

    Object jsonObj = getJsonAtPath(req.getPathInfo(), req.getParameterMap());
    Serialiser.serialise(res, jsonObj);
    return null;
  }

  private Object getJsonAtPath(String path, Map<String, String[]> parameterMap) throws IOException {
    URL resource = UrlHandler.class.getResource(path + ".json");
    if (resource != null) {
      return getObjectsFromStream(resource, parameterMap);
    } else {
      return null;
    }
  }

  private JSONArray getObjectsFromStream(URL resource, Map<String, String[]> parameterMap) throws IOException {

    String jsonPath = parameterMapToJsonPath(parameterMap);

    try(InputStream stream = resource.openStream()) {
      DocumentContext context = JsonPath.parse(stream);

      String filter = filterWithParameters(reduceParameterSet(parameterMap));
      if (filter != null)
        jsonPath = jsonPath + filter;

      JSONArray objects = context.read(jsonPath);

      return objects;
    }
  }

  private String parameterMapToJsonPath(Map<String, String[]> parameterMap) {
    if (parameterMap.containsKey("jsonpath")) {
      return parameterMap.get("jsonpath")[0];
    } else {
      return "$";
    }
  }

  private Map<String, String> reduceParameterSet(Map<String, String[]> parameterMap) {
    Map<String, String> map = new HashMap<>();
    for (String key: parameterMap.keySet()) {
      if (!key.equalsIgnoreCase("jsonpath"))
        map.put(key, parameterMap.get(key)[0]);
    }
    return map;
  }

  private String filterWithParameters(Map<String, String> parameters) {
    String filter = null;
    for (String key: parameters.keySet()) {
      if (filter == null) {
        filter = String.format("[?(@.%s=='%s')]", key, parameters.get(key)) ;
      } else {
        filter = String.format("%s[?(@.%s=='%s')]", filter, key, parameters.get(key));
      }
    }

    if (filter == null) {
      return null;
    } else {
      return filter;
    }
  }
}
