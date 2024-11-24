package ca.hinbest.daniel.konacommerce.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.time.LocalDateTime
import kotlin.test.assertEquals

class OrderTest {
    private var testUser = User(0, "testUser",
        "testUser", "testUser", LocalDateTime.of(2024, 1, 1, 1, 1, 0), null, Role(1))

    private val testOrder = Order(0, testUser, BigDecimal(500), LocalDateTime.of(2024, 1, 1, 1, 1, 0), "Completed")

    @Test
    fun getOrderId() {
        assertEquals(testOrder.orderId, 0)
    }

    @Test
    fun setOrderId() {
        testOrder.orderId += 1
        assertEquals(testOrder.orderId, 1)
    }

    @Test
    fun setInvalidOrderId() {
        assertThrows<IllegalArgumentException> {
            testOrder.validatedOrderId = -1 // Invalid order ID
        }
    }

    @Test
    fun getUser() {
        assertEquals(testUser, testOrder.user)
    }

    @Test
    fun setUser() {
        val tempUser = User(1, "tempUser",
            "temp@temp.ca", "user", LocalDateTime.of(2021, 1, 1, 1, 1, 0), null, Role(2))
        testOrder.user = tempUser
        assertEquals(tempUser, testOrder.user)
    }

    @Test
    fun getTotalAmount() {
        assertEquals(BigDecimal(500), testOrder.totalAmount)
    }

    @Test
    fun setTotalAmount() {
        testOrder.totalAmount = BigDecimal(5000)
        assertEquals(BigDecimal(5000), testOrder.totalAmount)
    }

    @Test
    fun setInvalidTotalAmount() {
        assertThrows<IllegalArgumentException> {
            testOrder.validatedTotalAmount = BigDecimal(-100) // Negative total amount
        }
    }

    @Test
    fun getOrderDate() {
        assertEquals(testOrder.orderDate, LocalDateTime.of(2024, 1, 1, 1, 1, 0))
    }

    @Test
    fun setOrderDate() {
        testOrder.orderDate = LocalDateTime.of(2021, 1, 1, 1, 1, 0)
        assertEquals(testOrder.orderDate, LocalDateTime.of(2021, 1, 1, 1, 1, 0))
    }

    @Test
    fun setInvalidOrderDate() {
        assertThrows<IllegalArgumentException> {
            testOrder.validatedOrderDate = LocalDateTime.of(1800, 1, 1, 1, 1, 0) // Invalid date
        }
    }

    @Test
    fun getStatus() {
        assertEquals(testOrder.status, "Completed")
    }

    @Test
    fun setStatus() {
        testOrder.status = "In Progress"
        assertEquals(testOrder.status, "In Progress")
    }

    @Test
    fun setInvalidStatus() {
        assertThrows<IllegalArgumentException> {
            testOrder.validatedStatus = "" // Blank status
        }
    }
}
