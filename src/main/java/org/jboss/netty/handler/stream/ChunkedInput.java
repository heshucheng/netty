/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * by the @author tags. See the COPYRIGHT.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.netty.handler.stream;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * Represents a large data stream which is consumed by {@link ChunkedWriteHandler}.
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 * @version $Rev$, $Date$
 */
public interface ChunkedInput {

    /**
     * Returns {@code true} if and only if there is any data left in the
     * stream.
     */
    boolean hasNextChunk() throws Exception;

    /**
     * Fetches a chunked data from the stream.  The returned chunk is usually
     * a {@link ChannelBuffer}, but you could extend an existing implementation
     * to convert the {@link ChannelBuffer} into a different type that your
     * handler or encoder understands.
     *
     * @return the fetched chunk, which is usually {@link ChannelBuffer}.
     *         {@code null} if there is no data left in the stream.
     */
    Object nextChunk() throws Exception;

    /**
     * Releases the resources associated with the stream.
     */
    void close() throws Exception;
}