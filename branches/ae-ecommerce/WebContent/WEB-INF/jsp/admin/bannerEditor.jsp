<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form modelAttribute="uploadItem" method="post"
	enctype="multipart/form-data">
	<fieldset>
		<legend>Banner</legend>

		<p>
			<form:label for="fileData" path="fileData">Banner: </form:label>
			<form:input path="fileData" type="file" />
		</p>

		<p>
			<input type="submit" />
		</p>

	</fieldset>
</form:form>
