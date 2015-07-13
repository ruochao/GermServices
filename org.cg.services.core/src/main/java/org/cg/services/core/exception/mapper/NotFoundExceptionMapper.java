package org.cg.services.core.exception.mapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cg.services.core.exception.ServiceExceptionMessage;

/**
 * A ExceptionMapper that maps NotFoundException to 404 NOT_FOUND
 * @author WZ
 *
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
	
	private static final Log LOG = LogFactory.getLog(NotFoundExceptionMapper.class);

	@Override
	public Response toResponse(NotFoundException exception) {
		LOG.error("Service Exception:", exception);

		ServiceExceptionMessage serviceExceptionDetails = new ServiceExceptionMessage(
				Response.Status.NOT_FOUND.getStatusCode(),
				Response.Status.NOT_FOUND.toString(),
				exception.getCause() !=null ? exception.getCause().getMessage() : "Path Not Found" );

		return Response.status(Response.Status.NOT_FOUND).entity(serviceExceptionDetails).type(MediaType.APPLICATION_JSON).build();
	}
}
