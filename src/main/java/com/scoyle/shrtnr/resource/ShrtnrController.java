package com.scoyle.shrtnr.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.scoyle.shrtnr.error.ErrorResponse;
import com.scoyle.shrtnr.request.ShrtnrRequest;
import com.scoyle.shrtnr.response.CreateResponse;
import com.scoyle.shrtnr.service.ShrtnrService;
import com.scoyle.shrtnr.service.ShrtnrServiceImpl;
import com.scoyle.shrtnr.service.UrlValidationUtil;

@Path("/newresource")
public class ShrtnrController {
	
	private ShrtnrService shrtnrService = new ShrtnrServiceImpl();
	
	@GET
	@Path("/{shortUrl}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt(@PathParam("shortUrl") String shortUrl) {
		
		String link = shrtnrService.getLongUrl(shortUrl);
		
        return Response
        		.status(Status.MOVED_PERMANENTLY)
        		.header("location", link)
        		.build();
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createShortUrl(ShrtnrRequest request) {
		
		if (!UrlValidationUtil.isValidRequest(request.getLongUrl())) {
			return Response
					.status(Status.BAD_REQUEST)
					.entity(new ErrorResponse(Status.BAD_REQUEST, "Invalid Request"))
					.build();
		}
		
		String encodedUrl = shrtnrService.generateShrtUrl(request);
		
		return Response
				.status(Status.CREATED)
				.entity(new CreateResponse(encodedUrl))
				.build();
	}
}
