/**
 *    Copyright 2016 Iron City Software LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package garmintools.adapters.garmin;

import garmintools.sections.DataLengthSection;
import garmintools.wrappers.TableOfContentsEntry;

import java.nio.ByteBuffer;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class DataLengthGarminAdapter implements GarminAdapter<List<Integer>> {
  @Override
  public List<Integer> read(DataLengthSection dataLengthSection, TableOfContentsEntry entry, ByteBuffer byteBuffer) {
    ImmutableList.Builder<Integer> listBuilder = ImmutableList.builder();
    Preconditions.checkArgument(entry.itemLength == 2);
    Preconditions.checkArgument(entry.itemQuantity <= 77, entry.toString());
    for (int i = 0; i < entry.itemQuantity; ++i) {
      listBuilder.add(byteBuffer.getShort() & 0xffff);
    }
    return listBuilder.build();
  }

  @Override
  public GarminOutput write(List<Integer> dataLengths) {
    GarminOutput output = new GarminOutput(dataLengths.size(), 2);
    for (int dataLength : dataLengths) {
      output.putShort((short) dataLength);
    }
    return output;
  }
}
