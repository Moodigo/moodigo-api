package com.zoutly.api.endpoint;

import com.zoutly.api.resource.EntityListResponse;
import com.zoutly.api.resource.EntityResponse;
import com.zoutly.api.service.DummyApiService;
import com.zoutly.core.model.Dummy;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Example Controller. Should cover useful techniques of Spring Controllers.
 */
@RestController
@RequestMapping(DummyController.URI)
public class DummyController implements ApiInterface {
    protected static final String URI = ApiInterface.API_URI + "/dummies";

    @Autowired
    private DummyApiService dummyService;

    /**
     * <p>
     * <b>Mapping for:</b><br/>
     * <code>/api/dummies or /api/dummies/</code>
     * - (trailing slash triggers too)<br/>
     * </p>
     */
    @RequestMapping(method = RequestMethod.GET)
    public EntityListResponse<Dummy> getAllDummies() {
        return dummyService.buildAll();
    }

    /**
     * <p>
     * <b>Mapping for:</b><br/>
     * <code>/api/dummies/1</code> or <code>/api/dummies/1/</code>
     *      - (also for URIs bellow)<br/>
     * <code>/api/dummies/1?whateverElseThanFormat=value</code>
     *      - viz {@link com.zoutly.api.endpoint.DummyController#getDummy(Long, String, boolean, String) getDummy(...)}<br/>
     * </p>
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public EntityResponse<Dummy> getDummy(@PathVariable Long id) {
        return dummyService.buildById(id);
    }

    /**
     * <p>
     * <b>Mapping for:</b><br/>
     * <code>/api/dummies/1?format=xml</code><br/>
     * <code>/api/dummies/1?format=json</code><br/>
     * <code>/api/dummies/1?format=xml&stub=[empty|true|false]</code>
     * - format = "xml"
     * stub = [true|false] (instead "" for empty, due to <code>@RequestParam(defaultValue = "true"),
     * eTag = null (instead thrown exception, due to <code>@RequestParam(required = false)</code>)<br/>
     * <code>/api/dummies/1?format=xml&etag=ha5h0f3nt1ty</code>
     * - format = "xml", stub = true, eTag = "ha5h0f3nt1ty"<br/>
     * <code>more...</code>
     * </p>
     * <p>
     * <p>
     * Because of <code>params = {"format", "format!="}</code> in <code>@RequestMapping</code>
     * query param <code>format</code> is required not empty for this <b>method mapping</b>.
     * </p>
     * <p>
     * <p>
     * On the other side query param <code>stub</code> is not required to trigger this <b>method mapping</b>.
     * Using <code>defaultValue = "val" </code> or <code>required = false</code>, it will be defined as "val" or null.
     * </p>
     * <p>
     * <p>
     * Do not confuse "required" in <b>method mapping</b> and required in <b>parameter mapping</b>
     * </p>
     * <p>
     * <p>
     * Notice <code>@PathVariable</code> vs. <code>@RequestParam</code>.
     * </p>
     * <p>
     * <p>
     * Notice <code>@RequestParam(value = "stub")</code> for different variable name.
     * </p>
     * <p>
     * <p>
     * <b><b>Not</b> mapping for:</b><br/>
     * <code>/api/dummies/1?stub=true</code>
     * - mapped by {@link com.zoutly.api.endpoint.DummyController#getDummy(Long)}.
     * Missing <code>?format</code>. <code>stub</code> not mapped to any param there.<br/>
     * <code>/api/dummies/1?stub=notBoolean</code>
     * - mapped by {@link com.zoutly.api.endpoint.DummyController#getDummy(Long)}.
     * As above, in addition <code>stub</code> can have any value as not mapped there.<br/>
     * <code>/api/dummies/1?format</code>
     * - mapped by {@link com.zoutly.api.endpoint.DummyController#getDummy(Long)}.
     * Not triggered because <code>format</code> empty.<br/>
     * <code>/api/dummies/1?format=xml&stub=stringValue</code>
     * - There is <b>no mapping</b> (both method and param) fitting this request. Existing method mapping but not fitting param mapping.
     * </p>
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", params = {"format"/*, "format!="*/})
    public EntityResponse<Dummy> getDummy(@PathVariable Long id,
                                          @RequestParam @NotEmpty String format,
                                          @RequestParam(value = "stub", defaultValue = "true") boolean stubRequested,
                                          @RequestParam(required = false) String eTag) {
        // has default value
        if(stubRequested) {
            System.out.println("Just stub requested");
        } else {
            System.out.println("Proper object requested");
        }

        // format cannot be null neither empty
        System.out.println("in " + format + " format");

        // needs to be checked
        if(eTag != null && !eTag.isEmpty()) {
            System.out.println("compare with " + eTag + " for NotModified header");
        }

        return dummyService.buildById(id);
    }


}