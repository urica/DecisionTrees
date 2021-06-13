package com.candor.sp.client.view;

import com.candor.sp.client.view.impl.TreeNode;
import com.google.gwtmockito.GwtMockito;
import com.google.gwtmockito.GwtMockitoTestRunner;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GwtMockitoTestRunner.class)
public class TreeNodeTest extends TestCase {

    private TreeNode treeNode;

    @Before
    public void setUp() {
        GwtMockito.initMocks(this);
        treeNode = new TreeNode();
    }

    @Test
    public void testGetters() {
        treeNode.getItemName();
        treeNode.getExpand();
        treeNode.getItemType();
        treeNode.getContainerForOtherItems();
        assertTrue(treeNode.getItemName() != null);
        assertTrue(treeNode.getExpand() != null);
        assertTrue(treeNode.getItemType() != null);
        assertTrue(treeNode.getContainerForOtherItems() != null);
    }
}
