/**
 * Copyright (c) 2012-2013, JCabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test case for {@link NotEmptyHandler}.
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 */
public final class NotEmptyHandlerTest {

    /**
     * NotEmptyHandler can return TRUE if result set is not empty.
     * @throws Exception If there is some problem inside
     */
    @Test
    @SuppressWarnings("PMD.CloseResource")
    public void returnsTrueIfResultSetIsNotEmpty() throws Exception {
        final ResultSet rset = Mockito.mock(ResultSet.class);
        final Statement stmt = Mockito.mock(Statement.class);
        Mockito.doReturn(true).when(rset).next();
        MatcherAssert.assertThat(
            new NotEmptyHandler().handle(rset, stmt),
            Matchers.is(true)
        );
    }

    /**
     * NotEmptyHandler can return FALSE if result set is empty.
     * @throws Exception If there is some problem inside
     */
    @Test
    @SuppressWarnings("PMD.CloseResource")
    public void returnsFalseIfResultSetIsEmpty() throws Exception {
        final ResultSet rset = Mockito.mock(ResultSet.class);
        final Statement stmt = Mockito.mock(Statement.class);
        Mockito.doReturn(false).when(rset).next();
        MatcherAssert.assertThat(
            new NotEmptyHandler().handle(rset, stmt),
            Matchers.is(false)
        );
    }

}
