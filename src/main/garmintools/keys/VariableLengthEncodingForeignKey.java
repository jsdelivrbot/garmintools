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

package garmintools.keys;

public class VariableLengthEncodingForeignKey {
  private final int byteIndex;
  private final int bitIndex;

  public VariableLengthEncodingForeignKey(int byteIndex, int bitIndex) {
    this.byteIndex = byteIndex;
    this.bitIndex = bitIndex;
  }

  public int getByteIndex() {
    return byteIndex;
  }

  public int getBitIndex() {
    return bitIndex;
  }

  @Override
  public boolean equals(Object that) {
    if (that == null || !(that instanceof VariableLengthEncodingForeignKey)) {
      return false;
    }
    VariableLengthEncodingForeignKey thatKey = (VariableLengthEncodingForeignKey) that;
    return byteIndex == thatKey.byteIndex && bitIndex == thatKey.bitIndex;
  }

  @Override
  public int hashCode() {
    return byteIndex * 31 + bitIndex;
  }

  @Override
  public String toString() {
    return String.format("%d.%d", byteIndex, bitIndex);
  }
}
