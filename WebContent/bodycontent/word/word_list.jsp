<%@taglib prefix="s" uri="/struts-tags"%>
<Table class="table">
	<tr>
		<td>Words</td>
		<td>Category</td>
		<td>Meaning</td>
	</tr>
	<s:iterator value="word">
		<tr>
			<s:iterator value="content">
				<td><s:property /></td>
			</s:iterator>
			<s:iterator value="category">
				<td><s:property value="name" /></td>
			</s:iterator>
			<s:iterator value="word_wordAnswer">
				<td><s:property value="content"/></td>
			</s:iterator>
		</tr>
	</s:iterator>
</Table>
