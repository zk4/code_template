<script setup></script>
<template>
	<div>
		<router-link to="/">Home</router-link>
		<router-link to="/hello">Hello</router-link>
	</div>
	<hr />
	<router-view />
</template>

<style scoped>
div {
	display: flex;
	position: absolute;
	top: 0px;
}
a {
	padding: 0 10px;
}

</style>
