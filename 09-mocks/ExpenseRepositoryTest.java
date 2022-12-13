package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        IFancyDatabase dbMockObject = mock(MyDatabase.class);
        ExpenseRepository er = new ExpenseRepository(dbMockObject);
        List<Expense> result = er.getExpenses();
        InOrder inOrder = inOrder(dbMockObject);
        inOrder.verify(dbMockObject).connect();
        inOrder.verify(dbMockObject).queryAll();
        inOrder.verify(dbMockObject).close();
        Expense[] emptyArr = {};
        assertArrayEquals(emptyArr, result.toArray());
    }

    @Test
    void saveExpenses() {
    }
}
