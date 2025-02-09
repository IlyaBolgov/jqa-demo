package com.example.api

import com.example.api.steps.BaseSteps
import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApiTest : BaseSteps() {

    @Test
    fun `should get a list of posts from JSONPlaceholder`() {
        val response = RestAssured.given()
            .spec(requestSpecification)
            .get("/posts")

        assertEquals(200, response.statusCode())

        val posts = response.jsonPath().getList<Any>("")
        assert(posts.isNotEmpty()) { "Posts should not be empty" }
    }

    @Test
    fun `should get a single post by id from JSONPlaceholder`() {
        val response = RestAssured.given()
            .spec(requestSpecification)
            .get("/posts/1")

        assertEquals(200, response.statusCode())

        val title = response.jsonPath().getString("title")
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", title)
    }

    @Test
    fun `should create a new post in JSONPlaceholder`() {
        val newPost = mapOf("title" to "foo", "body" to "bar", "userId" to 1)

        val response = RestAssured.given()
            .spec(requestSpecification)
            .body(newPost)
            .post("/posts")

        assertEquals(201, response.statusCode())

        val createdPostId = response.jsonPath().getInt("id")
        assert(createdPostId > 0) { "Post ID should be greater than 0" }
    }
}
